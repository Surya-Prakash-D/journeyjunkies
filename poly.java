// Node to represent each term of the polynomial
class Node {
    int coeff; // coefficient
    int pow;   // power
    Node next;

    Node(int c, int p) {
        coeff = c;
        pow = p;
        next = null;
    }
}

// Polynomial class
class Polynomial {
    Node head;

    // Function to add a term at end
    void addTerm(int coeff, int pow) {
        Node newNode = new Node(coeff, pow);

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // Function to add two polynomials
    static Polynomial add(Polynomial p1, Polynomial p2) {
        Polynomial result = new Polynomial();
        Node n1 = p1.head;
        Node n2 = p2.head;

        while (n1 != null && n2 != null) {
            if (n1.pow == n2.pow) {
                result.addTerm(n1.coeff + n2.coeff, n1.pow);
                n1 = n1.next;
                n2 = n2.next;
            } else if (n1.pow > n2.pow) {
                result.addTerm(n1.coeff, n1.pow);
                n1 = n1.next;
            } else {
                result.addTerm(n2.coeff, n2.pow);
                n2 = n2.next;
            }
        }

        // If terms are left in p1
        while (n1 != null) {
            result.addTerm(n1.coeff, n1.pow);
            n1 = n1.next;
        }

        // If terms are left in p2
        while (n2 != null) {
            result.addTerm(n2.coeff, n2.pow);
            n2 = n2.next;
        }

        return result;
    }

    // Function to display polynomial
    void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.coeff + "x^" + temp.pow);
            temp = temp.next;
            if (temp != null) System.out.print(" + ");
        }
        System.out.println();
    }
}

// Driver class
public class PolynomialAddition {
    public static void main(String[] args) {
        Polynomial p1 = new Polynomial();
        Polynomial p2 = new Polynomial();

        // Example: 5x^2 + 4x^1 + 2
        p1.addTerm(5, 2);
        p1.addTerm(4, 1);
        p1.addTerm(2, 0);

        // Example: 5x^1 + 5
        p2.addTerm(5, 1);
        p2.addTerm(5, 0);

        System.out.print("Polynomial 1: ");
        p1.display();

        System.out.print("Polynomial 2: ");
        p2.display();

        Polynomial sum = Polynomial.add(p1, p2);

        System.out.print("Sum: ");
        sum.display();
    }
}
