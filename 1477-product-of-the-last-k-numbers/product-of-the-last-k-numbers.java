class ProductOfNumbers {
    List<Integer> preProduct;
    public ProductOfNumbers() {
        preProduct = new ArrayList<>();
    }
    
    public void add(int num) {
        if(num == 0) {
            preProduct = new ArrayList<>();
        } else {
            if(preProduct.size() == 0) preProduct.add(num);
            else preProduct.add(preProduct.get(preProduct.size() - 1) * num);
        }
        
    }
    
    public int getProduct(int k) {
        if(preProduct.size() < k) return 0;
        if(preProduct.size() == k) return preProduct.get(preProduct.size() - 1);
        else return preProduct.get(preProduct.size() - 1) / preProduct.get(preProduct.size() - 1 - k);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */