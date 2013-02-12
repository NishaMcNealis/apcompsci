class Proc
  def to_l
    obj = Object.new
    obj.define_singleton_method(:_, &self)
    return lambda(&obj.method(:_))
  end
end

class Lisp
  attr_accessor :env

  def initialize
    @env = {
      :label => ->(name, val) {
        @env[name] = val
      },
      :quote => ->(rexpr) {
        rexpr[0]
      },
      :car => ->(list) {
        list[0]
      },
      :cdr => ->(list) {
        list.drop 1
      },
      :cons => ->(e,cell) {
        [e] + cell
      },
      :eq => ->(l, r) {
        l == r
      },
      :if => ->(cond, thn, els, ctx) {
        if eval(cond, ctx)
          eval thn, ctx
        else
          eval els, ctx
        end
      },
      :atom => ->(rexpr) {
        (rexpr.is_a? Symbol) or (rexpr.is_a? Numeric)
      },
      :map => ->(op, args) {
        args.inject op
      },
      :range => ->(srt=0, stp=10, step=1) {
        p srt.class, stp.class, step.class
        (srt..stp).step step
      }
    }
  end

  def apply fn, args
    fn = fn.to_sym if not fn.is_a? Symbol
    p "("+fn.to_s+" "+args.join(" ")+")"
    return args.inject(fn) if fn.to_proc.to_l and Lisp.instance_methods(true).include? fn
    return @env[fn].call(args, @env) if @env[fn].respond_to? :call
    self.eval @env[fn][2], Hash[*(@env[fn][1].zip args).flatten(1)]
  end
  
  def eval sexpr, ctx=@env
    if @env[:atom].call [sexpr]
      return ctx[sexpr] if ctx[sexpr]
      return sexpr
    end

    fn = sexpr[0]
    args = sexpr
    args.delete_at 0

    p fn
    p args

    args = args.map {|a| self.eval(a)} if not [:quote, :if, :map, :lambda].member? fn
    apply fn, args
  end
end

def repl l = Lisp.new
  while true
    print "> "
    $stdout.flush
    p l.eval eval gets
  end
end

#p l.eval [:label, :addone, [:quote, [:lambda, [:x], [:+, :x, 1]]]]
#p l.eval [:label, :self, [:quote, [:lambda, [:x], [:prim, :*, :x, 1]]]]
repl

#[:label, :func, [:lambda, [:x], [:+, :x, 1]]]
