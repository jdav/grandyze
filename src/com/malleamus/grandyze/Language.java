package com.malleamus.grandyze;

public enum Language {

	AB, AA, AF, AK, SQ, AM, AR, AN, HY, AS, AV, AE, AY, AZ, BM, BA, EU, BE, BN, BH, BI, BS, BR, BG, MY, CA, CH, CE, NY, ZH, CV, KW, CO, CR, HR, CS, DA, DV, NL, DZ, EN, FI, FR, DE, KO, PT, ES;

	public String getEnglishName() {
		switch (this) {
		case AB:
			return "Abkhaz";
		case AA:
			return "Afar";
		case AF:
			return "Afrikaans";
		case AK:
			return "Akan";
		case SQ:
			return "Albanian";
		case AM:
			return "Amharic";
		case AR:
			return "Arabic";
		case AN:
			return "Aragonese";
		case HY:
			return "Armenian";
		case AS:
			return "Assamese";
		case AV:
			return "Avaric";
		case AE:
			return "Avestan";
		case AY:
			return "Aymara";
		case AZ:
			return "Azerbaijani";
		case BM:
			return "Bambara";
		case BA:
			return "Bashkir";
		case EU:
			return "Basque";
		case BE:
			return "Belarusian";
		case BN:
			return "Bengali";
		case BH:
			return "Bihari";
		case BI:
			return "Bislama";
		case BS:
			return "Bosnian";
		case BR:
			return "Breton";
		case BG:
			return "Bulgarian";
		case MY:
			return "Burmese";
		case CA:
			return "Catalan";
		case CH:
			return "Chamorro";
		case CE:
			return "Chechen";
		case NY:
			return "Chichewa";
		case ZH:
			return "Chinese";
		case CV:
			return "Chuvash";
		case KW:
			return "Cornish";
		case CO:
			return "Corsican";
		case CR:
			return "Cree";
		case HR:
			return "Croatian";
		case CS:
			return "Czech";
		case DA:
			return "Danish";
		case DV:
			return "Divehi";
		case NL:
			return "Dutch";
		case DZ:
			return "Dzongkha";
		case EN:
			return "English";
		case FI:
			return "Finnish";
		case FR:
			return "French";
		case DE:
			return "German";
		case KO:
			return "Korean";
		case PT:
			return "Portuguese";
		case ES:
			return "Spanish";
		default:
			return "Unknown";
		}
	}

	public boolean isFavorite() {
		switch (this) {
		case CS:
		case DA:
		case NL:
		case KO:
		case DE:
		case EN:
		case FI:
		case FR:
		case ES:
		case PT:
			return true;
		default:
			return false;
		}
	}

	public boolean isRightLeft() {
		switch (this) {
		case AR:
			return true;
		default:
			return false;
		}
	}

	// Esperanto eo
	// Estonian et
	// Ewe ee
	// Faroese fo
	// Fijian fj
	// Fula, Fulah, Pulaar, Pular ff
	// Galician gl
	// Georgian ka
	// Greek (modern) el
	// Guaraní gn
	// Gujarati gu
	// Haitian, Haitian Creole ht
	// Hausa ha
	// Hebrew(modern) he
	// Herero hz
	// Hindi hi
	// Hiri Motu ho
	// Hungarian hu
	// Interlingua ia
	// Indonesian id
	// Interlingue ie
	// Irish ga
	// Igbo ig
	// Inupiaq ik
	// Ido io
	// Icelandic is
	// Italian it
	// Inuktitut iu
	// Japanese ja
	// Javanese jv
	// Kalaallisut, Greenlandic kl
	// Kannada kn
	// Kanuri kr
	// Kashmiri ks
	// Kazakh kk
	// Khmer km
	// Kikuyu, Gikuyu ki
	// Kinyarwanda rw
	// Kyrgyz ky
	// Komi kv
	// Kongo kg
	// Kurdish ku
	// Kwanyama, Kuanyama kj
	// Latin la
	// Luxembourgish, Letzeburgesch lb
	// Ganda lg
	// Limburgish, Limburgan, Limburger li
	// Lingala ln
	// Lao lo
	// Lithuanian lt
	// Luba-Katanga lu
	// Latvian lv
	// Manx gv
	// Macedonian mk
	// Malagasy mg
	// Malay ms
	// Malayalam ml
	// Maltese mt
	// Māori mi
	// Marathi (Marāṭhī) mr
	// Marshallese mh
	// Mongolian mn
	// Nauru na
	// Navajo, Navaho nv
	// Northern Ndebele nd
	// Nepali ne
	// Ndonga ng
	// Norwegian Bokmål nb
	// Norwegian Nynorsk nn
	// Norwegian no
	// Nuosu ii
	// Southern Ndebele nr
	// Occitan oc
	// Ojibwe, Ojibwa oj
	// Old Church Slavonic,Church Slavonic, Old Bulgarian cu
	// Oromo om
	// Oriya or
	// Ossetian, Ossetic os
	// Panjabi, Punjabi pa
	// Pāli pi
	// Persian (Farsi) fa
	// Polish pl
	// Pashto, Pushto ps
	// Quechua qu
	// Romansh rm
	// Kirundi rn
	// Romanian ro
	// Russian ru
	// Sanskrit (Saṁskṛta) sa
	// Sardinian sc
	// Sindhi sd
	// Northern Sami se
	// Samoan sm
	// Sango sg
	// Serbian sr
	// Scottish Gaelic, Gaelic gd
	// Shona sn
	// Sinhala, Sinhalese si
	// Slovak sk
	// Slovene sl
	// Somali so
	// Southern Sotho st
	// Sundanese su
	// Swahili sw
	// Swati ss
	// Swedish sv
	// Tamil ta
	// Telugu te
	// Tajik tg
	// Thai th
	// Tigrinya ti
	// Tibetan Standard, Tibetan, Central bo
	// Turkmen tk
	// Tagalog tl
	// Tswana tn
	// Tonga (Tonga Islands) to
	// Turkish tr
	// Tsonga ts
	// Tatar tt
	// Twi tw
	// Tahitian ty
	// Uyghur, Uighur ug
	// Ukrainian uk
	// Urdu ur
	// Uzbek uz
	// Venda ve
	// Vietnamese vi
	// Volapük vo
	// Walloon wa
	// Welsh cy
	// Wolof wo
	// Western Frisian fy
	// Xhosa xh
	// Yiddish yi
	// Yoruba yo
	// Zhuang, Chuang za
	// Zulu zu

}
