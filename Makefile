LOGGER_FRONT=awk '{print "\033[92mFRONT:\033[0m", $$0}'
LOGGER_BACK=awk '{print "\033[38;5;214m BACK:\033[0m", $$0}'

.PHONY: run run-backend run-frontend

run: run-backend run-frontend

run-backend:
	@cd backend && ./gradlew bootRun | $(LOGGER_BACK) &

run-frontend:
	@cd frontend && npm run dev | $(LOGGER_FRONT)
