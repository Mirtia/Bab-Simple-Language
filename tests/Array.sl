function main() {  
    
   i = {1, 3, 4, 5, 7};
   
   k = i{0};

   i{0} = 3;

   l = i{0};

   println("This is k: " + k);
   println("This is l: " + l);

}  
