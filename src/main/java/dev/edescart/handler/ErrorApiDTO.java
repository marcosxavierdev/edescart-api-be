package dev.edescart.handler;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ErrorApiDTO {
	private String message;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String description;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private List<ValidationDTO> validationsError;
}
