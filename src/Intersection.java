/**
 * Created by jiayicheng on 17/7/25.
 */
public class Intersection {
    //目的：判断两个列表是否有交叉
    //步骤：1、得到两个列表的长度和尾巴
    //     2、比较他们的尾巴，不一样就炸。
    //     3、再设两个指针到列表头里
    //     4、长的那个领先到长出的部分
    //     5、遍历直到一样
    class Node{
        public int data;
        public Node next;
        public Node(int d)
        {
            data=d;
        }
        void appendToTail(int d)
        {
            Node end=new Node(d);
            Node n=this;
            while(n.next!=null)
                 {
                n=n.next;
            }
            n.next=end;
        }
    }
    class Result{
        public Node tail;
        public int size;
        public Result(Node tail, int size)
        {
            this.size=size;
            this.tail=tail;
        }
    }

    Node findIntersection(Node n1,Node n2)
    {
if(n1==null||n2==null)
    return null;

        Result r1=size(n1);
        Result r2=size(n2);

        if(r1.tail!=r2.tail)
            return null;

        Node longer=r1.size>r2.size? n1:n2;
        Node shorter=r1.size<r2.size ?n1:n2;

        longer=getkthNode(longer,Math.abs(r1.size-r2.size));

        while(shorter!=longer)
        {
            shorter=shorter.next;
            longer=longer.next;
        }
        return longer;
    }

    Result size(Node n1)
    {
        if(n1==null) return null;
        Node n2=n1;
        int size=1;
        while(n1!=null)
        {
            n2=n2.next;
            size++;
        }
        return new Result(n2,size);
    }

    Node getkthNode(Node n1,int k)
    {
        Node n2=n1;
        while(k>0&&n2!=null)
        {
            n2=n2.next;
            k--;
        }
        return n2;
    }

}
