package Cadastros;


public class GetDuracaoHoras {
	
	private final Viagem _viagem;
	private int duracaoHoras;
	private int horaTermino;
	private int horaInicio;
	private int minutosTermino;
	private int minutosInicio;
	
	GetDuracaoHoras(Viagem source, int horaTermino, int horaInicio, int minutosTermino, int minutosInicio){
		_viagem = source;
		this.horaTermino = horaTermino;
		this.horaInicio = horaInicio;
		this.minutosTermino = minutosTermino;
		this.minutosInicio = minutosInicio;
		
	}
	

	public int calcular() {
		if (horaTermino == horaInicio)
			duracaoHoras = 0;
		if (horaTermino > horaInicio) //varias possibilidades... 
			if (horaTermino == horaInicio + 1) {  
				if (minutosTermino < minutosInicio)  //nao chegou a uma hora
					duracaoHoras = 0;
				else //durou pelo menos uma hora
					duracaoHoras = 1;
			} else { //possivelmente ultrapassou duas horas
				if (horaTermino - horaInicio > 2) //
					duracaoHoras = horaTermino - horaInicio;
				else if (horaTermino - horaInicio == 2 &&   //certamente menos de duas horas  
						 minutosTermino < minutosInicio)    //e mais de uma hora
					duracaoHoras = 1;
				else //duracao de duas horas, certamente
					duracaoHoras = 2;
					
			}
		if (horaTermino < horaInicio) 
			duracaoHoras = -1; //para casos em que a hora de termino nao foi registrada
		return duracaoHoras;
	}
	
	
}
