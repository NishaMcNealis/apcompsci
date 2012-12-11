def stirling(n)
  Math.sqrt(2*Math::PI*n)*(n.to_f/Math::E)**n
end

def factorial(n)
  if n < 2
    1
  else
    n*factorial(n-1)
  end
end

(0..1000).each {|num|
  f = factorial(num).round.to_f
  s = stirling(num).round.to_f
  puts "#{num}\n\t#{f}\n\t#{s}\n\t\t#{(100*(1-s/f))}%\n"
}
