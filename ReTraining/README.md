### Data types

1. Primitive Data Types (Các kiểu dữ liệu nguyên thủy)
- Bao gồm: Integer, Character, Boolean, and Floating Point

| Kiểu dữ liệu  | Giá trị mặc định | Kích thước |
| ------------- |:----------------:| ----------:|
| boolean       | false            | 1 bit      |
| char          | '\u0000'         | 2 byte     |
| byte          | 0                | 1 byte     |
| short         | 0                | 2 byte     |
| int           | 0                | 4 byte     |
| long          | 0L               | 8 byte     |
| float         | 0.0f             | 4 byte     |
| double        | 0.0d             | 8 byte     |


2. Non-primitive
- Bao gồm Classes, Interfaces và Arrays


### Exception
Trong Java có 2 loại exception: checked và unchecked. Tất cả các checked exception được kế thừa từ lớp Exception ngoại trừ lớp RuntimeException. RuntimeException là lớp cơ sở của tất cả các lớp unchecked exception. Đó cũng là dấu hiệu để nhận biết đâu là checked exception và đâu là unchecked exception.

Điểm khác biệt giữa các lớp checked và unchecked expcetion chính là thời điểm xác định được expcetion có thể xảy ra.

- Checked exceptions

Là loại exception xảy ra trong lúc compile time, nó cũng có thể được gọi là compile time exceptions. Loại exception này không thể bỏ qua được trong quá trình compile, bắt buộc ta phải handle nó.

Các lớp extends từ lớp Throwable ngoại trừ RuntimeException và Error được gọi là checked exception.

Ví dụ: IOException, FileNotFoundException, NoSuchFieldException, ….

-UnChecked exceptions

Là loại exception xảy ra tại thời điểm thực thi chương trình, nó cũng có thể gọi là runtime exceptions đó là programming bugs, lỗi logic của chương trình… Loại exception này được bỏ qua trong quá trình compile, không bắt buộc ta phải handle nó.

Các lớp extends từ RuntimeException được gọi là unchecked exception.

Ví dụ: NullPointerException, NumberFormatException, ArrayIndexOutOfBoundsException, DivideByZeroException, …

Ví dụ một biến có giá trị null, thực hiện bất kỳ hoạt động nào bởi biến đó sẽ xảy ra ngoại lệ NullPointerException.

- Error
Error là những vấn đề nghiêm trọng liên quan đến môi trường thực thi của ứng dụng hoặc hệ thống mà lập trình viên không thể kiểm soát. Nó thường làm chết chương trình.

Lớp Error định nghĩa các ngoại lệ mà không thể bắt (catch) từ chương trình.

Ví dụ: OutOfMemoryError, VirtualMachineError, and StackOverflowError, …

- Một số lưu ý
Tại một thời điểm chỉ xảy ra một ngoại lệ và tại một thời điểm chỉ có một khối catch được thực thi. Khi exception đã bị bắt ở một catch thì các catch tiếp theo sẽ không được bắt.

Tất cả các khối catch phải được sắp xếp từ cụ thể nhất đến chung nhất (từ exception con đến exception cha), tức là phải khai báo khối lệnh catch để xử lý lỗi NullPointerException, ArithmeticException, … trước khi khai báo catch để xử lý lỗi Exception.

Khối lệnh finally luôn được thực thi dù chương trình có xảy ra ngoại lệ hay không (ngay cả sử dụng lệnh return).
Đối với mỗi khối try, có thể không có hoặc nhiều khối catch, nhưng chỉ có một khối finally.

Khối finally sẽ không được thực thi nếu chương trình bị thoát bằng cách gọi System.exit() hoặc xảy ra một lỗi (Error) không thể tránh khiến chương trình bị chết.

See more: https://gpcoder.com/2430-xu-ly-ngoai-le-trong-java-exception-handling/
https://www.programiz.com/java-programming

### OOP có 4 tính chất đặc thù chính, các ngôn ngữ OOP nói chung đều có cách để diễn tả:

Tính đóng gói: Có thể gói dữ liệu (data, biến, trạng thái) và mã chương trình (code, phương thức) thành một cục gọi là lớp (class) để dễ quản lí. Trong cục này thường data rất rối rắm, không tiện cho người không có trách nhiệm truy cập trực tiếp, nên thường ta sẽ che dấu data đi, chỉ để lòi phương thức ra ngoài. Ví dụ hàng xóm sang mượn búa, thay vì bảo hàng xóm cứ tự nhiên vào lục lọi, ta sẽ bảo: "Ấy bác ngồi chơi để tôi bảo cháu lấy cho". Ngôn ngữ Ruby "phát xít" đến nỗi dấu tiệt data, cấm không cho truy cập từ bên ngoài. Ngoài ra, các lớp liên quan đến nhau có thể được gom chung lại thành package (tùy ngôn ngữ mà còn gọi là module, namespace v.v.).

Tính trừu tượng: Có câu "program to interfaces, not to concrete implementations". Nghĩa là khi viết chương trình theo phong cách hướng đối tượng, khi thiết kế các đối tượng, ta cần rút tỉa ra những đặc trưng của chúng, rồi trừu tượng hóa thành các interface, và thiết kế xem chúng sẽ tương tác với nhau như thế nào. Nói cách khác, chúng ta định ra các interface và các contract mà chúng cần thỏa mãn.

Tính thừa kế: Lớp cha có thể chia sẻ dữ liệu và phương thức cho các lớp con, các lớp con khỏi phải định nghĩa lại những logic chung, giúp chương trình ngắn gọn. Nếu lớp cha là interface, thì lớp con sẽ di truyền những contract trừu tượng từ lớp cha.

Tính đa hình: Đối tượng có thể thay đổi kiểu (biến hình). (1) Với các ngôn ngữ OOP có kiểu, có thể mượn phát biểu của C++ "con trỏ kiểu lớp cha có thể dùng để trỏ đến đối tượng kiểu lớp con". Như vậy khi khai báo chỉ cần khai báo p có kiểu lớp cha, còn sau đó nó trỏ đến đâu thì kệ cha con nó: nếu cha và con cùng có phương thức m, thì từ p cứ lôi m ra gọi thì chắc chắn gọi được, không cần biết hiện tại p đang trỏ đến cha hay con. Khi lớp B thừa kế từ lớp A, thì đối tượng của lớp B có thể coi là đối tượng của lớp A, vì B chứa nhiều thứ thừa kế từ A. (2) Với ngôn ngữ OOP không có kiểu như Ruby, có thể mượn phát biểu của phương pháp xác định kiểu kiểu con vịt: "nếu p đi như vịt nói như vịt, thì cứ coi nó là vịt". Như vậy nếu lớp C có phương thức m, mà có thể gọi phương thức m từ đối tượng p bất kì nào đó, thì cứ coi p có kiểu là C.

### Java Polymorphism
- **Types of Polymorphism**
In Java, Polymorphism can be divided into two types:

Run-time Polymorphism
In Java, run-time polymorphism can be achieved through method overriding.

Compile-time Polymorphism
The compile-time polymorphism can be achieved through method overloading and operator overloading in Java.

- ** Why Polymorphism?**
Polymorphism allows us to create consistent(nhất quán) code. For example,

Suppose we need to render a circle and a square. To do so, we can create a `Polygon` class and inherited two subclasses `Circle` and `square` from it. In this case, it makes sense to create a method having the same name `render()` in both these subclasses rather than creating methods with different names.

In our method overloading example, we have used the same method name `displayPattern()` to display two different patterns for consistency.

The `print()` method in Java is also an example of Polymorphism (method overloading). The same method is used to print values of different types like `char`, `int`, `String`, etc. We can also use the same method to print multiple values at once.


### Java Abstract class and Abstract methods
- **Why Java Abstraction?**
Abstraction is an important concept of object-oriented programming. Abstraction only shows the needed information and all the unnecessary details are kept hidden. This allows us to manage complexity by omitting or hiding details with a simpler, higher-level idea.

A practical example of abstraction can be motorbike brakes. We know what brake does. When we apply the brake, the motorbike will stop. However, the working of the brake is kept hidden from us.

The major advantage of hiding the working of the brake is that now the manufacturer can implement brake differently for different motorbikes, however, what brake does will be the same.

Let's take an example that helps us to better understand Java abstraction.

- ** key points to remember**
We use the `abstract` keyword to create abstract classes and methods.
An abstract method doesn't have any implementation (method body).
A class containing abstract methods should also be abstract.
We cannot create objects of an abstract class.
To implement features of an abstract class, we inherit subclasses from it and create objects of the subclass.
A subclass must override all abstract methods of an abstract class. However, if the subclass is declared abstract, it's not mandatory to override abstract methods.
We can access the static attributes and methods of an abstract class using the reference of the abstract class. For example,
```
Animal.staticMethod();
```

### Java Interface
- **Why use Interfaces?**
Interfaces provide specifications that a class (which implements it) must follow.

In our above example, we have used `getArea()` as a specification inside the interface `Polygon`. This is like setting a rule that, we should be able to get the area of every polygon. So any class that implements the Polygon interface must provide an implementation for the `getArea()` method.

Similar to abstract classes, interfaces help us to achieve abstraction in Java. Here, we know `getArea()` calculates the area of polygons but the way area is calculated is different for different polygons. Hence, the implementation of `getArea()` is independent of one another.

Interfaces are also used to achieve multiple inheritance in Java. If a subclass is inherited from two or more classes, it's multiple inheritance.

In Java, multiple inheritance is not possible by extending classes. However, a class can implement multiple interfaces. This allows us to get the functionality of multiple inheritance in Java. For example,
```
interface Line {
   ...
}
interface Polygon {
   ...
}
class Rectangle implements Line, Polygon{
   ...
}
```
Here, `Rectangle` has to provide an implementation for all methods of both `Line` and `Polygon`.

Also, interfaces support private methods with the release of Java 9. Now you can use private methods and private static methods in interfaces.

Since you cannot instantiate interfaces, private methods are used as helper methods that provide support to other methods in interfaces.


- **default methods in Interfaces**

With the release of Java 8, methods with implementation (default methods) were introduced inside an interface. Before that, all the methods were abstract in Java.

To declare default methods inside interfaces, we use the `default` keyword. For example,
```
public default void getSides() {
   // body of getSides()
}
```

- **Why default methods?**
Let's take a scenario to understand why default methods are introduced in Java.

Suppose, we need to add a new method in an interface.

We can add the method in our interface easily without implementation. However, that's not the end of the story. All our classes that implement that interface must provide an implementation for the method.

If a large number of classes were implementing this interface, we need to track all these classes and make changes in them. This is not only tedious but error-prone as well.

To resolve this, Java introduced default methods. Default methods are inherited like ordinary methods.

Let’s take an example to have a better understanding of default methods.


### Collections
- **Why the Collections Framework?**
The Java collections framework provides various data structures and algorithms that can be used directly. This has two main advantages:

We do not have to write code to implement these data structures and algorithms manually.
Our code will be much more efficient as the collections framework is highly optimized.
Moreover, the collections framework allows us to use a specific data structure for a particular type of data. Here are a few examples,

If we want our data to be unique, then we can use the Set interface provided by the collections framework.
To store data in key/value pairs, we can use the Map interface.
The ArrayList class provides the functionality of resizable arrays.

- **List**
In Java, the `List` interface is an ordered collection that allows us to store and access elements sequentially. It extends the `Collection` interface.

Since `List` is an interface, we cannot create objects from it.
In order to use functionalities of the `List` interface, we can use these classes:
`ArrayList`
`LinkedList`
`Vector`
`Stack`

- **Java List vs. Set**
Both the `List` interface and the `Set` interface inherits the `Collection` interface. However, there exists some difference between them.

Lists can include duplicate elements. However, sets cannot have duplicate elements.
Elements in lists are stored in some order. However, elements in sets are stored in groups like sets in mathematics.
- **Vector**
The `Vector` class is an implementation of the `List` interface that allows us to create resizable-arrays similar to the ArrayList class.

 - **Java Vector vs. ArrayList**
In Java, both ArrayList and Vector implements the List interface and provides the same functionalities. However, there exist some differences between them.

The Vector class synchronizes each individual operation. This means whenever we want to perform some operation on vectors, the Vector class automatically applies a lock to that operation.

It is because when one thread is accessing a vector, and at the same time another thread tries to access it, an exception called ConcurrentModificationException is generated. Hence, this continuous use of lock for each operation makes vectors less efficient.

However, in array lists, methods are not synchronized. Instead, it uses the Collections.synchronizedList() method that synchronizes the list as a whole.

Note: It is recommended to use ArrayList in place of Vector because vectors are not threadsafe and are less efficient.

- **Stack**
- The Java collections framework has a class named Stack that provides the functionality of the stack data structure

- In stack, elements are stored and accessed in Last In First Out manner. That is, elements are added to the top of the stack and removed from the top of the stack.

- Use ArrayDeque Instead of Stack
The Stack class provides the direct implementation of the stack data structure. However, it is recommended not to use it. Instead, use the ArrayDeque class (implements the Deque interface) to implement the stack data structure in Java.

- **Queue**
https://www.programiz.com/java-programming/queue



### Java Generics
In Java, Generics helps to create classes, interfaces, and methods that can be used with different types of objects (data). Hence, allows us to reuse our code.


