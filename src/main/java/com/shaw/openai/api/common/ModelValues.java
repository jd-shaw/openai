package com.shaw.openai.api.common;

/**
 * @author shaw
 * @date 2023/3/2
 */
public class ModelValues {

	public static String Ada = "ada";
	public static String Babbage = "babbage";
	public static String Curie = "curie";
	public static String Davinci = "davinci";
	public static String Cushman = "cushman";

	public static String CurieInstructBeta = ModelNameHolder.builder(BaseModel.Curie, Subject.InstructBeta);
	public static String DavinciInstructBeta = ModelNameHolder.builder(BaseModel.Davinci, Subject.InstructBeta);

	public static String TextDavinciV1 = ModelNameHolder.builder(BaseModel.Davinci, Subject.Text, "001");
	public static String TextDavinciV2 = ModelNameHolder.builder(BaseModel.Davinci, Subject.Text, "002");
	public static String TextDavinciV3 = ModelNameHolder.builder(BaseModel.Davinci, Subject.Text, "003");
	public static String TextAdaV1 = ModelNameHolder.builder(BaseModel.Ada, Subject.Text, "001");
	public static String TextBabbageV1 = ModelNameHolder.builder(BaseModel.Babbage, Subject.Text, "001");
	public static String TextCurieV1 = ModelNameHolder.builder(BaseModel.Curie, Subject.Text, "001");

	public static String CurieSimilarityFast = ModelNameHolder.builder(BaseModel.Curie, Subject.SimilarityFast);

	public static String CodeDavinciV1 = ModelNameHolder.builder(BaseModel.Davinci, Subject.Code, "001");
	public static String CodeCushmanV1 = ModelNameHolder.builder(BaseModel.Cushman, Subject.Code, "001");
	public static String CodeDavinciV2 = ModelNameHolder.builder(BaseModel.Davinci, Subject.Code, "002");

	public static String TextSimilarityAdaV1 = ModelNameHolder.builder(BaseModel.Ada, Subject.TextSimilarity, "001");
	public static String TextSimilarityBabbageV1 = ModelNameHolder.builder(BaseModel.Babbage, Subject.TextSimilarity,
			"001");
	public static String TextSimilarityCurieV1 = ModelNameHolder.builder(BaseModel.Curie, Subject.TextSimilarity,
			"001");
	public static String TextSimilarityDavinciV1 = ModelNameHolder.builder(BaseModel.Davinci, Subject.TextSimilarity,
			"001");

	public static String TextSearchAdaDocV1 = ModelNameHolder.builder(BaseModel.Ada, Subject.TextSearchDocument, "001");
	public static String TextSearchBabbageDocV1 = ModelNameHolder.builder(BaseModel.Babbage, Subject.TextSearchDocument,
			"001");
	public static String TextSearchCurieDocV1 = ModelNameHolder.builder(BaseModel.Curie, Subject.TextSearchDocument,
			"001");
	public static String TextSearchDavinciDocV1 = ModelNameHolder.builder(BaseModel.Davinci, Subject.TextSearchDocument,
			"001");
	public static String TextSearchAdaQueryV1 = ModelNameHolder.builder(BaseModel.Ada, Subject.TextSearchQuery, "001");
	public static String TextSearchBabbageQueryV1 = ModelNameHolder.builder(BaseModel.Babbage, Subject.TextSearchQuery,
			"001");
	public static String TextSearchCurieQueryV1 = ModelNameHolder.builder(BaseModel.Curie, Subject.TextSearchQuery,
			"001");
	public static String TextSearchDavinciQueryV1 = ModelNameHolder.builder(BaseModel.Davinci, Subject.TextSearchQuery,
			"001");

	public static String TextEditDavinciV1 = ModelNameHolder.builder(BaseModel.Davinci, Subject.Edit, "001");
	public static String CodeEditDavinciV1 = ModelNameHolder.builder(BaseModel.Davinci, Subject.CodeEdit, "001");

	public static String CodeSearchAdaCodeV1 = ModelNameHolder.builder(BaseModel.Ada, Subject.CodeSearchCode, "001");
	public static String CodeSearchBabbageCodeV1 = ModelNameHolder.builder(BaseModel.Babbage, Subject.CodeSearchCode,
			"001");
	public static String CodeSearchAdaTextV1 = ModelNameHolder.builder(BaseModel.Ada, Subject.CodeSearchText, "001");
	public static String CodeSearchBabbageTextV1 = ModelNameHolder.builder(BaseModel.Babbage, Subject.CodeSearchText,
			"001");

	public static String ChatGpt3_5Turbo = "gpt-3.5-turbo";
	public static String ChatGpt3_5Turbo0301 = "gpt-3.5-turbo-0301";

	private static final class ModelNameHolder {

		public static String builder(BaseModel baseModel, Subject subject) {
			String baseModelStr = enumToString(baseModel);
			return builder(baseModelStr, enumToString(subject, baseModelStr), null);
		}

		public static String builder(BaseModel baseModel, Subject subject, String version) {
			String baseModelStr = enumToString(baseModel);
			return builder(baseModelStr, enumToString(subject, baseModelStr), version);
		}

		private static String builder(String baseModel, String subject, String version) {
			String response = subject != null ? subject : baseModel;
			if (version != null && !version.isEmpty()) {
				response += "-" + version;
			}
			return response;
		}
	}

	private static String enumToString(Model model) {
		switch (model) {
		case Ada:
			return Ada;
		case Babbage:
			return Babbage;
		case Curie:
			return Curie;
		case CurieInstructBeta:
			return CurieInstructBeta;
		case Davinci:
			return Davinci;
		case DavinciInstructBeta:
			return DavinciInstructBeta;
		case TextDavinciV1:
			return TextDavinciV1;
		case TextDavinciV2:
			return TextDavinciV2;
		case TextDavinciV3:
			return TextDavinciV3;
		case TextAdaV1:
			return TextAdaV1;
		case TextBabbageV1:
			return TextBabbageV1;
		case TextCurieV1:
			return TextCurieV1;
		case CurieSimilarityFast:
			return CurieSimilarityFast;
		case CodeDavinciV1:
			return CodeDavinciV1;
		case CodeCushmanV1:
			return CodeCushmanV1;
		case CodeDavinciV2:
			return CodeDavinciV2;
		case TextSimilarityAdaV1:
			return TextSimilarityAdaV1;
		case TextSimilarityBabbageV1:
			return TextSimilarityBabbageV1;
		case TextSimilarityCurieV1:
			return TextSimilarityCurieV1;
		case TextSimilarityDavinciV1:
			return TextSimilarityDavinciV1;
		case TextSearchAdaDocV1:
			return TextSearchAdaDocV1;
		case TextSearchBabbageDocV1:
			return TextSearchBabbageDocV1;
		case TextSearchCurieDocV1:
			return TextSearchCurieDocV1;
		case TextSearchDavinciDocV1:
			return TextSearchDavinciDocV1;
		case TextSearchAdaQueryV1:
			return TextSearchAdaQueryV1;
		case TextSearchBabbageQueryV1:
			return TextSearchBabbageQueryV1;
		case TextSearchCurieQueryV1:
			return TextSearchCurieQueryV1;
		case TextSearchDavinciQueryV1:
			return TextSearchDavinciQueryV1;
		case CodeSearchAdaCodeV1:
			return CodeSearchAdaCodeV1;
		case CodeSearchBabbageCodeV1:
			return CodeSearchBabbageCodeV1;
		case CodeSearchAdaTextV1:
			return CodeSearchAdaTextV1;
		case CodeSearchBabbageTextV1:
			return CodeSearchBabbageTextV1;
		case TextEditDavinciV1:
			return TextEditDavinciV1;
		case CodeEditDavinciV1:
			return CodeEditDavinciV1;
		case ChatGpt3_5Turbo:
			return ChatGpt3_5Turbo;
		case ChatGpt3_5Turbo0301:
			return ChatGpt3_5Turbo0301;
		default:
			throw new IllegalArgumentException("Invalid model: " + model);
		}
	}

	private static String enumToString(BaseModel baseModel) {
		switch (baseModel) {
		case Ada:
			return Ada;
		case Babbage:
			return Babbage;
		case Curie:
			return Curie;
		case Davinci:
			return Davinci;
		case Cushman:
			return Cushman;
		default:
			throw new IllegalArgumentException("Invalid base model: " + baseModel);
		}
	}

	private static String enumToString(Subject subject, String baseModel) {
		switch (subject) {
		case Text:
			return String.format("text-%s", baseModel);
		case InstructBeta:
			return String.format("%s-instruct-beta", baseModel);
		case SimilarityFast:
			return String.format("%s-similarity-fast", baseModel);
		case TextSimilarity:
			return String.format("text-similarity-%s", baseModel);
		case TextSearchDocument:
			return String.format("text-search-%s-doc", baseModel);
		case TextSearchQuery:
			return String.format("text-search-%s-query", baseModel);
		case CodeSearchCode:
			return String.format("code-search-%s-code", baseModel);
		case CodeSearchText:
			return String.format("code-search-%s-text", baseModel);
		case Code:
			return String.format("code-%s", baseModel);
		case CodeEdit:
			return String.format("code-%s-edit", baseModel);
		case Edit:
			return String.format("text-%s-edit", baseModel);
		default:
			throw new IllegalArgumentException("Invalid subject: " + subject);
		}
	}
}
