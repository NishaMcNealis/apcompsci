text = File.read ARGV[0]
text.gsub! " ", ""
text = text.downcase.gsub /[^a-z]/, ''
puts text[0..256]
