from fastapi import APIRouter

router = APIRouter()

@router.post(
    "/experiments",
    tags=["experiments"])
async def create_experiment(request)