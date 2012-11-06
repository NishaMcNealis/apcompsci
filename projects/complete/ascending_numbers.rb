=begin
This is some code I wrote for math class, to figure out the answer to one of the CAML questions.
The question asks how many numbers there are in some interval where the digits are unique and 
increasing in value, left to right.

This code solves that via brute force.
=end
max = 123456789 #Top value

def in_order?(num)
  s = num.to_s
  t=0
  s.each_char {|char|
    if char.to_i > t
      t=char.to_i
    else
      return false
    end
  }
  return true
end

count=0
for i in (10..max)
  if in_order?(i.to_s)
    count += 1
    if i % 1000 != 0
      print i
      print "   "
      puts count
    end
  end
end
puts count
