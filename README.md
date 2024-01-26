# LinkedList CellPhone Manager

This project is a custom implementation of a singly linked list in Java. It manages a list of `CellPhone` objects, each with attributes for serial number, brand, year of manufacture, and price.

I invite anyone to use this small project to learn singly linked list or to increase their knowledge on it.

## What is a Singly Linked List?

A singly linked list is a type of data structure that is made up of nodes that are created using self-referential structures. Each node contains a data element and a reference (link) to the next node in the sequence. This allows for a dynamic and efficient approach to managing collections of data.

The list gets its name from the way it only links in one direction from one node to the next. The start of the linked list is referred to as the head, and the end of the list is known as the tail.

<img src="https://media.geeksforgeeks.org/wp-content/cdn-uploads/20200922124319/Singly-Linked-List1.png" alt="Singly Linked List">
### Why use a Singly Linked List?

Singly linked lists are particularly useful in situations where you need to maintain an ordered collection of elements, but the precise sequence or number of elements may not be known in advance. They allow for efficient insertions or deletions from the list without having to reorganize the entire data structure.

This is particularly useful in certain scenarios like managing a real-time system where system resources need to be quickly and efficiently re-allocated or de-allocated.

More specifically, in this project, we use a singly linked list to manage a collection of `CellPhone` objects. It provides an efficient way to add, remove, find, and display the `CellPhone` objects. This is a perfect real life example of using a linked list.

You will see different methods created for the sole purpose of showing how easy it is to manipulate such a powerful data structure. Writing a linked list method isn't a by heart thing. If you truly understand the logic, every time you write a linked list the method will look slightly different, because there are hundreds of ways to make a method doing exactly the same thing.

One more intersting aspect of this project worth noting is security/data leaks. This is something very important in Java and in program. Please read below.

## Security Considerations

In the context of this project, one of the main security considerations is the prevention of data leaks. As we're dealing with sensitive data like cell phone serial numbers, it's crucial to ensure that this data is handled securely.

### Avoiding Security Leaks

One way we've addressed this in the project is by ensuring that the `CellPhone` objects are not directly accessible from outside the `CellList` class. This encapsulation prevents unauthorized access to the data.

Furthermore, when implementing the `clone()` method in the `CellPhone` class, we've ensured that it creates a deep copy of the object. This means that it creates a new `CellPhone` object with the same data, rather than just copying the reference to the existing object. This prevents potential security leaks that could occur if the original object were modified after being cloned.

### Secure Coding Practices

In addition to these specific measures, it's important to follow secure coding practices in general. This includes practices like validating and sanitizing input data, using secure functions for handling data, and regularly reviewing and updating the code to address potential security vulnerabilities.

Remember, security is not a one-time task, but an ongoing process. It's important to keep up to date with the latest security threats and mitigation strategies, and to regularly review and update your code to ensure it remains secure.

<img src="https://imageio.forbes.com/specials-images/imageserve/65aebd3ac11780d4dcfde276/Red-circuit-board-background--open-padlock-displayed-alongside--data-leak--and/960x0.jpg?format=jpg&width=960" alt="Singly Linked List" width = 200px>

## Classes

The project consists of three main classes:

1. `CellPhone`: Represents a cellphone object with attributes for serial number, brand, year of manufacture, and price.

2. `CellList`: A custom implementation of a singly linked list. It contains `CellPhone` objects in its nodes, referred to as `CellNode` objects.

3. `CellListUtilization`: The driver class for the program. It tests the methods of the `CellList` class.

## Usage

The program reads from a file named "Cell_Info.txt", creates `CellPhone` objects from the data, and adds them to a `CellList`. It then performs various operations on the `CellList`, such as adding, inserting, deleting, replacing, finding, and checking for the existence of `CellPhone` objects. I added a bunch of test cases that are commented out for the goal of anyone accessing this code to learn from it and to hopefully have a better understanding on singly linked list.

## Contributing

Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change. If you have any knowledge to add to the read me, please feel free to pull request.

## GitHub

[https://github.com/Riasy7/LinkedList-CellPhone-Manager](https://github.com/Riasy7/LinkedList-CellPhone-Manager)
