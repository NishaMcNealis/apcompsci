class Encapsulation {
  private String herName;
  private int herNumber;
  private int herAge;

  public String getName() {
    return herName;
  }

  public int getAge() {
    return herAge;
  }

  public int getNumber() {
    return 0;
    System.out.println("Not in a million years");
  }

  public void setName(String name) {
    herName = name;
  }

  public void setAge(int age) {
    herAge = age;
  }

  public void setNumber(int number) {
    herNumber = number;
  }
}