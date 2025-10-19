from application.metric_service import MetricRepositoryInterface
from domain.entities import Metric
from infraestructure.models import ExperimentDocument


class MongoExperimentRepository(ExperimentRepositoryInterface):

    async def save(self, experiment: Experiment) -> str:
        document = ExperimentDocument(**experiment.model_dump())
        result = await document.insert()
        uuid = str(result.id)
        return uuid
