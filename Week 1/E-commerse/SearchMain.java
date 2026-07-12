import java.util.Arrays;
import java.util.Comparator;

// 1. PRODUCT CLASS
class Product {
    int productId;
    String productName;
    String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product[ID=" + productId + ", Name=" + productName + ", Category=" + category + "]";
    }
}

// 2. MAIN RUNNER WITH SEARCH ALGORITHMS
public class SearchMain {

    // Linear Search Implementation
    public static Product linearSearch(Product[] products, int targetId) {
        for (Product product : products) {
            if (product.productId == targetId) {
                return product; // Found
            }
        }
        return null; // Not found
    }

    // Binary Search Implementation (Requires array to be sorted by productId)
    public static Product binarySearch(Product[] products, int targetId) {
        int low = 0;
        int high = products.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (products[mid].productId == targetId) {
                return products[mid]; // Found
            }
            if (products[mid].productId < targetId) {
                low = mid + 1; // Search right half
            } else {
                high = mid - 1; // Search left half
            }
        }
        return null; // Not found
    }

    public static void main(String[] args) {
        // Create an unsorted array of products
        Product[] products = {
            new Product(105, "Wireless Mouse", "Electronics"),
            new Product(101, "Mechanical Keyboard", "Electronics"),
            new Product(104, "Gaming Headset", "Electronics"),
            new Product(102, "Leather Wallet", "Accessories"),
            new Product(103, "Running Shoes", "Footwear")
        };

        int target = 104;

        // ---- Test Linear Search ----
        System.out.println("--- Running Linear Search ---");
        Product res1 = linearSearch(products, target);
        System.out.println("Result: " + res1);

        // ---- Test Binary Search (Must sort the array first!) ----
        System.out.println("\n--- Running Binary Search ---");
        
        // Sorting products by productId before running binary search
        Arrays.sort(products, Comparator.comparingInt(p -> p.productId));
        
        Product res2 = binarySearch(products, target);
        System.out.println("Result: " + res2);
    }
}