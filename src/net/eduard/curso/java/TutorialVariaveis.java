package net.eduard.curso.java;

public class TutorialVariaveis {

	
	public static class Pessoa{
		
		  String nome = "Sem nome";
		 int idade = 1;
	}
	
	
	public static void main(String[] args) {

		Pessoa p1 = new Pessoa();
		p1.nome = "Edu";
		p1.idade = 15;
		Pessoa p2 = new Pessoa();
		p2.nome = "Gabriel";
		p2.idade = 16;
		System.out.println(p1.nome);
		System.out.println(p2.nome);
		System.out.println(p1.idade);
		System.out.println(p2.idade);

		

	}

}
