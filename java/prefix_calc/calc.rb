def is_num? s
  s.to_s.match(/\A[+-]?\d+?(\.\d+)?\Z/) == nil ? false : true 
end

def process post, res, ops
  post.each do |i|
    p res
    if is_num? i
      res.push i.to_f
    elsif ops[i.to_sym]
      a = res.pop
      b = res.pop
      res.push ops[i.to_sym].call(a, b)
    end
  end
  res.pop
end

<<<<<<< HEAD
post = ARGV[0].reverse.split " "
=======
post_s = ARGV[0].split(" ").reverse
>>>>>>> 953608dcaac56b30f72ee5aa6aa74301409ab5d2
res = []
ops = {
  :+ => ->(a, b) { a+b },
  :- => ->(a, b) { a-b },
  :* => ->(a, b) { a*b },
  :/ => ->(a, b) { a/b },
  :^ => ->(a, b) { a**b }
}
p process(post, res, ops)
