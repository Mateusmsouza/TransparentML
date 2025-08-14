from pymongo import AsyncMongoClient

from beanie import Document, Indexed, init_beanie

async def init_db(client: AsyncMongoClient, models: list[Document]):
    client = AsyncMongoClient(
        "mongodb://user:pass@host:27017"
    )
    await init_beanie(database=client.db_name, document_models=models)
