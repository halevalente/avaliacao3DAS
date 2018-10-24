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
			duracaoMinutos = minutosTermino - minutosInicio;
		else {
			duracaoMinutos = 60 - minutosInicio + minutosTermino;
			if (duracaoMinutos == 60) //caso especial
				duracaoMinutos = 0;
		}
		return duracaoMinutos;
	}
	
}
