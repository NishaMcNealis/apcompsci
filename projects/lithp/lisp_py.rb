class Env < Hash
  attr_accessor :outer

  def initialize params=[], args=[], outer=nil
    self.update(Hash[zip(params, args)])
    @outer = outer
  end

  def find var
    return self if self.contains? var
    return self.outer.find(var)
  end

  def add_globals
    syms  = [
             :+, :-
            ]
    meths = [
             1.method(:+),
             2.method(:-)
            ]

    self.update(Hash[zip(syms, meths.collect{|e| lambda(&e)})])
    #p Hash[[:+, :-].collect {|op| [op, lambda(&method(op))]}]
#    env.update([].collect {|op| op => lambda(&method op)})
#    env.update {
#      :+ => method :+
#    }
  end
end

class Lisp
  def eval x, env
    if x.is_a? Symbol
      return env[x]
    elsif not x.is_a? Array
      return x
    elsif x == :quote
      _, exp = x
    elsif x == :if
        _, test, cons, alt = x
      if eval(test, env)
        return eval cons
      else
        return eval alt
      end
    elsif x == :def
      _, var, exp = x
      env[var] = eval exp, env
    elsif x == :lambda
      _, vars, exp = x
      return ->(*args) {eval(exp, Env.new(vars, args, env))}
    elsif x == :begin
      x[1..-1].each {|o|
        val = eval o, env
      }
      return val
    else
      exps = x.collect {|x| eval(x, env)}
      proc = exps.pop 0
      return proc(*exps)
    end
  end
end

l = Lisp.new
#l.eval [:
e = Env.new
e.add_globals
l.eval [:+, 1, 2], e
