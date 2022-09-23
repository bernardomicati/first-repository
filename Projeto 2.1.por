programa
{
	
	funcao inicio()
	{
	

		cadeia nota
		inteiro nota1
		inteiro nota2
		inteiro resposta1
		escreva("Olá aluno! Deseja iniciar a verificação da sua nota?")
		escreva("\nDigite 1 para sim e 2 para não")
		leia(resposta1)
		se(resposta1 == 1){
			 escreva("Digite sua primeira nota:\n") 
		leia(nota1)
		limpa()
		escreva("Digite sua segunda nota: \n")
		leia(nota2)
		escreva("O resultado foi: "+(nota1 + nota2))	
		escreva("Obrigado por usar meu programa, manda 10 reais no pix agora rs")	
		limpa()
			} se(resposta1 == 2) {
				escreva("Ok... Até a proxima, FRACASSADO")
				} senao { 
					escreva("Digite um numero entre 1 e 2")
					}
				}}
		
		
		
			


/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 236; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */