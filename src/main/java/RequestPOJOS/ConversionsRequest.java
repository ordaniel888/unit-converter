package RequestPOJOS;

import FileReader.FileReader;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

public class ConversionsRequest {

    @JsonProperty(value = "conversionRatios", required = true)
    private List<ConversionRatio> conversionRatios;

    @JsonProperty(value = "UnitsToConvert", required = true)
    private List<ConversionRequest> conversionRequests;

    @JsonCreator
    private ConversionsRequest(
            @JsonProperty(value = "conversionRatios", required = true) List<ConversionRatio> conversionRatios,
            @JsonProperty(value = "UnitsToConvert", required = true) List<ConversionRequest> conversionRequests) {
        this.conversionRatios = conversionRatios;
        this.conversionRequests = conversionRequests;
    }

    public static ConversionsRequest fromFile(String fileName) throws IOException {
        String strJson = new FileReader(fileName).read();
        return new ObjectMapper().readValue(strJson, ConversionsRequest.class);
    }

    private static boolean isRatioDelimiter(String line) {
        return line.equals("\n");
    }

    public List<ConversionRatio> getConversionRatios() {
        return conversionRatios;
    }

    public List<ConversionRequest> getConversionRequests() {
        return conversionRequests;
    }

    public void setConversionRatios(List<ConversionRatio> conversionRatios) {
        this.conversionRatios = conversionRatios;
    }

    public void setConversionRequests(List<ConversionRequest> conversionRequests) {
        this.conversionRequests = conversionRequests;
    }
}