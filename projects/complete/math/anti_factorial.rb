num = ARGV[0].to_i
i = 1
while num > 0 do
  num /= i
  i += 1
end
puts i-2
