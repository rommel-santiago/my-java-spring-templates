Lambda Expressions
------------------

    MyFirstFunctionalInterface fi =  public void oneAbstractMethod (String n) {
                                        System.out.println(n);
                                     }
* Which can be shortened as Lambda expression:
 
    MyFirstFunctionalInterface fi =  (String n) -> { System.out.println(n); }

* Which can be further shortened as

* And since its a single line code can be further shortened:

    MyFirstFunctionalInterface fi =  (n) -> System.out.println(n);
