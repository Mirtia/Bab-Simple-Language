function main() { 
    arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    pfor(i=5:10)
    {
        arr_at_i = arr{i};
        println("This is a pfor i: " + i);
        println("This is arr at index " + i + ": " + arr_at_i);
    }   
}   