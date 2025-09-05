import pytest

from domain.entities import Experiment, Metric
from domain.repositories.experiment_repository_interface import ExperimentRepositoryInterface
from application.experiment_service import ExperimentService


class FakeExperimentRepository(ExperimentRepositoryInterface):

    def save(self, experiment: Experiment) -> Experiment:
        return experiment


def test_create_experiment_success():

    fake_repository = FakeExperimentRepository()
    experiment_service = ExperimentService(repository=fake_repository)

    experiment = Experiment(
        name="Test Experiment",
        description="Testing TDD in application layer",
        tags=["ml", "tdd"],
        metrics=[Metric(name="accuracy", value=0.95, step=1)]
    )

    result = experiment_service.create(experiment=experiment)
    assert result.name == "Test Experiment"
    assert result.description == "Testing TDD in application layer"
    assert result.metrics[0].value == 0.95
