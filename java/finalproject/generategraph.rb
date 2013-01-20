require 'rubygems'
require 'gruff'
require 'csv'

class String
  def underscore
    self.gsub(/::/, '/').
    gsub(/([A-Z]+)([A-Z][a-z])/,'\1_\2').
    gsub(/([a-z\d])([A-Z])/,'\1_\2').
    tr("-", "_").
    downcase
  end
end

g = Gruff::Line.new false
g.title = "Times for Operations on #{ARGV[0]}"
g.x_axis_label = "Number of elements"
g.y_axis_label = "Nanosec time"
to_hash = []
(0..10).each do |el|
  to_hash.push el
  to_hash.push el*100
end
g.labels = Hash[to_hash]

insert = []
search = []
delete = []

count = 0
CSV.foreach("#{ARGV[0]}Test.csv") do |row|
  begin
    insert.push row[3].to_i
    search.push row[4].to_i
    delete.push row[5].to_i
    g.labels[count] = row[2]
  rescue
  end
end

g.data 'Insert', insert
g.data 'Search', search
g.data 'Delete', delete

g.write "#{ARGV[0].underscore}_test.png"
