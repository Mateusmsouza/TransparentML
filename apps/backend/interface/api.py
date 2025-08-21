import logging

from fastapi import FastAPI, status
from fastapi.responses import JSONResponse

from pymongo import AsyncMongoClient

from infraestructure.db.init_db import init_db
from settings import settings
from infraestructure.models import ExperimentDocument, MetricDocument
from infraestructure.mongo_repository import BeanieExperimentRepository
from application.experiment_service import ExperimentService
from domain.entities import Experiment 

app = FastAPI(
    title="TransparentML Backend",
    version="0.0.1"
)

experiment_service = ExperimentService(repository=BeanieExperimentRepository())

@app.on_event("startup")
async def start_db():
    uri = f"mongodb://{settings.mongodb_user}:" \
        f"{settings.mongodb_passwd}@{settings.mongodb_host}"
    logging.info(uri)
    logging.info(settings)
    logging.info(f"starting mongodb {uri}")
    await init_db(
        client=AsyncMongoClient(uri),
        models=[ExperimentDocument, MetricDocument])
    logging.info("mongodb started")


@app.get("/ping")
async def root():
    return {"message": "Pong"}

@app.post("/v1/experiment")
async def create_experiment(experiment: Experiment) -> str:
    uuid = await experiment_service.create(experiment=experiment)
    return JSONResponse(content={"_id": uuid}, status_code=status.HTTP_201_CREATED)
