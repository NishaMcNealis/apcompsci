def is_num?(s)
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

post_s = ARGV[0].split(" ").reverse
res = []
ops = {
  :+ => ->(a, b) { a+b },
  :- => ->(a, b) { a-b },
  :* => ->(a, b) { a*b },
  :/ => ->(a, b) { a/b }
}
p process(post_s, res, ops)
