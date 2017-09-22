//*********************************************************************************************************************************
/* 4	Implement a Singleton or dynamic Proxy using Java 7+.

*///*********************************************************************************************************************************

//Singleton example using Enum - We can guarantee this will only be instantiated as a constant once
public enum Singleton {
  INSTANCE;
	int value = 0;

  public int getValue() {
      return value;
  }

  public void setValue(int value) {
      this.value = value;
  }
}