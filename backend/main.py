from fastapi import FastAPI

app = FastAPI(
    title="TransparentML Backend",
    version="0.0.1"
)

@app.get("/ping")
async def root():
    return {"message": "Pong"}

