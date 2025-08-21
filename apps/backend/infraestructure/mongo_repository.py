from application.experiment_service import ExperimentRepositoryInterface
from domain.entities import Experiment
from infraestructure.models import ExperimentDocument


class BeanieExperimentRepository(ExperimentRepositoryInterface):

    async def save(self, experiment: Experiment) -> str:
        document = ExperimentDocument(**experiment.model_dump())
        result = await document.insert()
        uuid = str(result.id)
        return uuid
