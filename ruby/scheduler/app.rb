require 'yaml'

$db = YAML.load(File.read "class.yaml")

module ClassDB
  def ClassDB.getbyid(id)
    return $db[id]
  end
end

class SchoolClass
  @id = 0
  @name = ""
  @preqreqs = []
  def add(id, name, prereqs)
    @id = id
    @name = name
    @prereqs = prereqs
  end

  def addbyid(id)
    ClassDB::getbyid id
  end
end

a = SchoolClass.new
a.add(*a.addbyid("0"))
puts a.inspect
