package test;

import java.util.ArrayList; import java.util.List;

import com.care.health.model.Examination;

public class Tree {
Examination	examinationtest= new Examination();
List<Examination> examinations = new ArrayList<Examination>();
public Node root = new Node("root");
int i =0;
public Tree(int kArity)
{
    Node.maxNrOfChildren=kArity;
    root.parent=null;
}

public void traverseTree(Node rootNode)//depth first
{
    System.out.println(rootNode.name);
    if(rootNode.children.size()!=0)
        for(Node ch : rootNode.children)
            traverseTree(ch);
}
public void traversel(Examination rootExamination)//depth first
{
	
	rootExamination.setId("makkkkkkkk");
	///System.out.println(rootExamination.getSciName());
    if(null!=rootExamination.getExamChild()){
    if(rootExamination.getExamChild().size()!=0)
        for(int i=0;i<rootExamination.getExamChild().size();i++)
        	  traversel((Examination)rootExamination.getExamChild().get(i));
    }
}

public void traversel1(Examination rootExamination){
	this.examinations.add(rootExamination);
	///examinations.add(rootExamination);
	System.out.println(rootExamination.getId());
    if(null!=rootExamination.getExamChild()){
    if(rootExamination.getExamChild().size()!=0)
        for(int i=0;i<rootExamination.getExamChild().size();i++)
        	  traversel1((Examination)rootExamination.getExamChild().get(i));
    }
	
}

public static void main(String args[])
{
	Tree tree=new Tree(3);
	Examination examination = new Examination();
	examination.setSciName("1");
	Examination examination1 = new Examination();
	examination1.setSciName("2");
	Examination examination3 = new Examination();
	examination3.setSciName("3");
	Examination examination4 = new Examination();
	examination4.setSciName("4");
	Examination examination5 = new Examination();
	examination5.setSciName("5");
	Examination examination6 = new Examination();
	examination6.setSciName("6");
	
	Examination examination7 = new Examination();
	examination7.setSciName("7");
	
	
	Examination examination8 = new Examination();
	examination8.setSciName("8");
	Examination examination9 = new Examination();
	examination9.setSciName("9");
	
	List<Examination> examinations = new ArrayList<Examination>();
	examinations.add(examination4);

	List<Examination> examinations1 = new ArrayList<Examination>();
	examinations1.add(examination5);
	examinations1.add(examination6);
	examinations1.add(examination7);
	
	List<Examination> examinations2 = new ArrayList<Examination>();
	examinations2.add(examination8);
	examinations2.add(examination9);
	
	examination1.setExamChild(examinations1);
	examinations.add(examination1);
	examination3.setExamChild(examinations2);
	examinations.add(examination3);
	examination.setExamChild(examinations );
//	System.out.println(examination4.getId());
	//examination.setExamChild(examinations1);
	tree.traversel(examination);
    tree.traversel1(examination);
    for(int i=0;i<tree.examinations.size();i++){
    	System.out.println(tree.examinations.get(i).getId()+"  "+i);
    }
    
//	Examination e1 = new Examination();
//	tree.traversel1(e1);
//	System.out.println(e1.getSciName());
	//    Tree tree=new Tree(3);
//    Node a = new Node("a");
//    Node b = new Node("b");
//    Node c = new Node("c");
//    Node d = new Node("d");
//    Node e = new Node("e");
//    Node f = new Node("f");
//    Node g = new Node("g");
//    tree.root.addChild(a);
//    a.addChild(b);
//    a.addChild(f);
//    a.addChild(g);
//    c.addChild(d);
//    d.addChild(e);
//    tree.root.addChild(c);
//    tree.traverseTree(tree.root);
}
}