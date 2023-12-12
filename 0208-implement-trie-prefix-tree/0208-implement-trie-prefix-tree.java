


class Trie {
    private class Node{
        char ch;
        boolean eow;
        Node []node=new Node[26];
        Node(char ch){
            this.ch=ch;
        }
    }
    private Node root;
    public Trie() {
        root=new Node(' ');
    }
    
    public void insert(String word) {
        Node temp=root;
        for(char ch:word.toCharArray()){
            if(temp.node[ch-'a']==null){
                Node node=new Node(ch);
                temp.node[ch-'a']=node;
            }
            temp=temp.node[ch-'a'];
        }
        temp.eow=true;
    }
    
    public boolean search(String word) {
        Node temp=root;
        for(char ch:word.toCharArray()){
            if(temp.node[ch-'a']==null) return false;
            temp=temp.node[ch-'a'];
        }
        return temp.eow?true:false;
    }
    
    public boolean startsWith(String word) {
        Node temp=root;
        for(char ch:word.toCharArray()){
            if(temp.node[ch-'a']==null) return false;
            temp=temp.node[ch-'a'];
        }
        return true;
    }
}