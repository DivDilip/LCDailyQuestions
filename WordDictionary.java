class WordDictionary {

    /** Initialize your data structure here. */
    private class Node{
     private HashMap<Character,Node> cl=new HashMap<Character,Node>();   
        public boolean isEndNode=false;
        public Node() {
        
    }
        public Node addCharacter(char ch){
            if(cl.containsKey((Character)ch)){
                return cl.get((Character)ch);
            }else{
                Node temp=new Node();
                cl.put((Character)ch,temp);
                return temp;
            }
            
        }
        public void markEnd(){
            isEndNode=true;
        }
        public boolean isEnd(){
            return isEndNode;
        }

         public Boolean search(String word){
            if(word==null){
                return false;
            }else if(word.isEmpty()){
                return isEnd();
            }else if(word.length()>0){
                char  charToMatch=word.charAt(0);
                Boolean isMatch=false;
                if(charToMatch=='.'){
                    if(!cl.values().isEmpty()){
                        for(Node nextChar:cl.values()){
                            if(nextChar.search(word.substring(1))){
                                isMatch=true; 
                                break;                           
                            }
                            
                        }    
                    }
                    
                }else{
                    isMatch=cl.containsKey((Character)charToMatch)&&cl.get((Character)charToMatch).search(word.substring(1));
                    
                }

            return isMatch;
            }
             return false;
            }
            }
           
        


        
    
    private Node root=new Node();
    public WordDictionary() {
        
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        Node currNode=root;
        for(char c:word.toCharArray()){
           currNode= currNode.addCharacter(c);
        }
        currNode.markEnd();
        
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        if(word==null){
            return false;
        }
       return  root.search(word);     
}
}
