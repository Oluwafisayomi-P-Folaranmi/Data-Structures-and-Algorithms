### **Linked Positional List (analogous to how LinkedList works)**

Publicly, the for-each loop doesn't have an initial, condition, or increment like a normal for loop. It hides all that from you. You only, **"say the type you want to work with, then give the collection it is stored in."**

#### **Conceptual Syntax**

The `for-each` loop has the syntax:

```java
for (DataType variable : collection/array) {
    // body
}
```

Read it as, "for each variable IN collection/array"

for example,

```java
for (String s : myList) {
    System.out.printl(s);
}
```

#### **Initial, Condition, Increment**

How does the `for-each` loop look work? The **initial**, **condition**, and **increment** is all handled by **Iterator** behind the scene. This:

```java
for (String s : myList) {
        System.out.printl(s);
}
```

is conceptually equivalent to this:

```java
for (Iterator<String> it = myList.iterator(); it.hasNext()) {
    String s = it.next();
    System.out.println(s);
}
```

Thus, when you want to create your collection to have an iterator, have it in mind that:

+ Initial: `iterator()`
+ Condition: `hasNext()`
+ Increment: `next()`
