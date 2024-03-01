package utilsdev.utils;

public class MaskUD {

	/**
	 * Formata um CNPJ com uma máscara específica.
	 *
	 * @param cnpj O CNPJ a ser formatado, representado como uma string de 14
	 *             dígitos numéricos.
	 * @return O CNPJ formatado com a máscara "XX.XXX.XXX/XXXX-XX".
	 * @throws IllegalArgumentException Se o CNPJ não conter 14 dígitos numéricos.
	 */
	public static String formatCNPJ(String cnpj) {
		if (cnpj == null) {
			return "";
		}

		// Remove caracteres não numéricos
		cnpj = cnpj.replaceAll("[^0-9]", "");

		if (cnpj.length() != 14) {
			throw new IllegalArgumentException("O CNPJ deve conter 14 dígitos numéricos.");
		}

		// Aplica a máscara de formatação
		return cnpj.replaceAll("(\\d{2})(\\d{3})(\\d{3})(\\d{4})(\\d{2})", "$1.$2.$3/$4-$5");
	}

}
