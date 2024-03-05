package com.mtopgul.collectionsAndGenerics.sorting.comparable;

/**
 * @author muhammed-topgul
 * @since 05/03/2024 11:23
 */
public class Product implements Comparable<Product> {
    private int id;
    private String name;

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Product other))
            return false;
        return this.id == other.id;
    }

    @Override
    public int compareTo(Product product) {
        return this.name.compareTo(product.name);
    }
}
