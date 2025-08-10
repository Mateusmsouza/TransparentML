FROM python:3.10-slim

WORKDIR /app
RUN pip install --upgrade uv

COPY . .
RUN uv sync --frozen

CMD ["python", "-m", "uvicorn", "main:app", "--host", "0.0.0.0", "--port", "8000"]
