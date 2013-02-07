class Proc
  def to_l
    obj = Object.new
    obj.define_singleton_method(:_, &self)
    return obj.method(:_).to_proc
  end
end

class Lisp
  def initialize
    @env = {
      :label => lambda {|(name, val), _|
        @env[name] = val
      },
      :quote => lambda {|rexpr, _|
        rexpr[0]
      },
      :car => lambda { |(list), _|
        list[0]
      },
      :cdr => lambda {|(list), _|
        list.drop 1
      },
      :cons => lambda {|(e,cell), _|
        [e] + cell
      },
      :eq => lambda {|(l,r), _|
        l == r
      },
      :if => lambda {|(cond, thn, els), ctx|
        if eval(cond, ctx)
          eval thn, ctx
        else
          eval els, ctx
        end
      },
      :atom => lambda {|(rexpr), _|
        (rexpr.is_a? Symbol) or (rexpr.is_a? Numeric)
      },
      :map => lambda {|(op, *args), _|
        args.inject op
      },
      :prim => lambda {|(op), _|
        op.to_proc.to_l
      }#,
#      :macro => lambda {|(label, op), _|
#        @env[label] = @env[op]
#      }
    }
    #    @env[:lambda].call
    #def apply op, a, b, &block
    #  binding = block.send :binding
    #  eval "#{a.to_s} #{op.to_s} #{b.to_s}", binding
    #end
    # apply(:+, 1, 2) {}
  end

  def apply fn, args
    p fn,",",args
    return @env[fn].call(args, @env)\
    if @env[fn].respond_to? :call
    self.eval @env[fn][2], Hash[*(@env[fn][1].zip args).flatten(1)]
  end
  
  def eval sexpr
    #sexpr = [:a]
    if @env[:atom].call [sexpr], @env
      return @env[sexpr] if @env[sexpr]
      return sexpr
    end
    #sexpr = [:+, 1, 2]
    fn = sexpr[0]
    args = sexpr.drop 1
    args = args.map {|a| self.eval(a)} if not [:quote, :if].member? fn
#    p fn; p args; puts
    apply fn, args
  end
end

l = Lisp.new
#p l.eval [:label, :addone, [:quote, [:lambda, [:x], [:+, :x, 1]]]]
#p l.eval [:label, :self, [:quote, [:lambda, [:x], [:prim, :*, :x, 1]]]]
#p l.eval [:macro, [:+, [:prim, :x]]]
l.eval [:label, :+, [:prim, :+]]
#l.eval [:label, :+, [:prim, :+]]
p l.eval [:+, 1, 2]













[:+, 1, 2]
#[:label, :func, [:lambda, [:x], [:+, :x, 1]]]
