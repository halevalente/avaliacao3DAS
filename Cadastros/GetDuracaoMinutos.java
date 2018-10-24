package Cadastros;

public class GetDuracaoMinutos {

	private final Viagem _viagem;
	private int duracaoMinutos;
	private int minutosTermino;
	private int minutosInicio;
	
	GetDuracaoMinutos(Viagem source, int minutosTermino, int minutosInicio){
		_viagem = source;
		this.minutosTermino = minutosTermino;
		this.minutosInicio = minutosInicio;
		
	}
	
	int calcular() {
		if (minutosTermino > minutosInicio) 
			setDuracaoMinutos(subtrair(minutosTermino, minutosInicio));
		else {
			setDuracaoMinutos(adicionar(subtrair(60, minutosInicio), minutosTermino));
			if (duracaoMinutos == 60) //caso especial
				setDuracaoMinutos(0);
		}
		return duracaoMinutos;
	}
	
	public int subtrair(int arg1, int arg2) {
		return arg1-arg2;
	}
	
	public int adicionar(int arg1, int arg2) {
		return arg1+arg2;
	}
	
	void setDuracaoMinutos(int duracao){
		duracaoMinutos = duracao;
	}
	
}
