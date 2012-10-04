require 'yaml'

$db = YAML.load(File.read "class.yaml")

module ClassDB
  def ClassDB.getbyname(name)
    return $db[name]
  end
end

class SchoolClass
  @name = ""
  @preqreqs = []

  def initialize(name)
    add(ClassDB::getbyname name)
  end

  def add(hash)
    @name = hash["name"]
    @prereqs = hash["prereqs"]
  end

  def prereqs
    @prereqs
  end
end

def r_prereqs(tclass, j)
  p = tclass.prereqs
  if not p
    return j
  end
  p.each {|a| j.push(a)}
  p.collect {|req|
    c = SchoolClass.new req
    q = r_prereqs(c, j)
  }
end

a = SchoolClass.new "AP Computer Science"
puts r_prereqs(a, [])[0][0][0].inspect
