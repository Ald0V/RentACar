package cu.edu.cujae.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public  class Validator {
    /**
     * Valida una cadena de caracteres para el formato de las placas de carro que se usa específicamente en Cuba.
     * @param numberPlate Recibe como parámetro un String que debe ser el número de placa de un carro.
     * @return Retorna unbooleano con valor verdadero si el String fue correctamente validado, y falso en caso contrario.
     */
    public boolean ValidatePlate (String numberPlate){
        boolean Validated = false;
       String PlateFormat = "^[T]{1}[0-9]{6}$";
    /* Métodos usados en validaciones de este tipo de campos */
        Pattern pattern = Pattern.compile(PlateFormat);
        Matcher matcher = pattern.matcher(numberPlate);

        if(matcher.matches()){
        Validated = true;
        }
        return Validated;
    }

    /**
     * Valida una cadena de texto para que no contenga espacios en blanco y solo caracteres alfanuméricos.
     * @param chain Recibe como parámetro una cadena de texto de hasta 50 caracteres.
     * @return Retorna true o false según resulte la validación.
     */
    public boolean validateString(String chain) {
        boolean validated = false;
        String trimmedBrand = chain.trim();
        if (trimmedBrand.length() > 0 && trimmedBrand.length() <= 50 && trimmedBrand.matches("^[a-zA-Z0-9]*$")) {
            validated = true;
        }
        return validated;
    }
    
	public boolean isAgeCorrect(int edad) {
		return edad >= 18 && edad <= 60;
	}
	
    public boolean isPassportCorrect(String str) {
        return str.matches("\\d{11}");
    }
	
    public boolean isPhoneCorrect(String str) {
        return str.matches("[\\d+\\-\\)\\(]{1,15}");
    }

    }
