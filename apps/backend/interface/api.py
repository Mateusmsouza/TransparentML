import logging

from fastapi import FastAPI

from pymongo import AsyncMongoClient

from infraestructure.db.init_db import init_db
from settings import settings
from model.experiment import Experiment


app = FastAPI(
    title="TransparentML Backend",
    version="0.0.1"
)


@app.on_event("startup")
async def start_db():
    logging.info(f"starting mongodb mongodb://{settings.mongodb_user}:{
                 settings.mongodb_passwd}@{settings.mongodb_host} ")

    f"mongodb://{settings.mongodb_user}:{settings.mongodb_passwd}@{settings.mongodb_host}"
    await init_db(
        client=AsyncMongoClient(
            f"mongodb://{settings.mongodb_user}:{
                settings.mongodb_passwd}@{settings.mongodb_host}"
        ),
        models=[Experiment])
    logging.info("mongodb started")


@app.get("/ping")
async def root():
    return {"message": "Pong"}
