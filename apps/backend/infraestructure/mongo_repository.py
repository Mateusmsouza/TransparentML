from application.experiment_service import ExperimentRepositoryInterface
from domain.entities import Experiment
from infraestructure.models import ExperimentDocument


class BeanieExperimentRepository(ExperimentRepositoryInterface):

    async def save(self, experiment: Experiment) -> str:
        document = ExperimentDocument(**Experiment.model_dump())
        return await document.insert()
