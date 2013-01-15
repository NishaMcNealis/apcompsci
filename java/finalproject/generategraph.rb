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

g = Gruff::Line.new(false)
g.title = "Times for Operations on #{ARGV[0]}"
g.x_axis_label = "Number of elements"
g.y_axis_label = "Nanosec time"
g.labels = {}

insert = []
search = []
delete = []

count = 0
CSV.foreach("#{ARGV[0]}Test.csv") do |row|
  begin
    insert.push(row[3].to_i) if row[3].to_i < 110000
    search.push(row[4].to_i) if row[4].to_i < 110000
    delete.push(row[5].to_i) if row[5].to_i < 110000
    g.labels[count] = row[2]
  rescue
  end
end

g.data('Insert', insert)
g.data('Search', search)
g.data('Delete', delete)

g.write("#{ARGV[0].underscore}_insert.png")
