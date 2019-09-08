package net.corda.training.state

import net.corda.core.contracts.BelongsToContract
import net.corda.core.contracts.LinearState
import net.corda.core.contracts.UniqueIdentifier
import net.corda.core.identity.Party
import net.corda.core.serialization.CordaSerializable
import net.corda.training.contract.NodeInfoContract
import net.corda.training.model.NodeInfoContainer
import net.corda.training.model.NodeInfoContainerType
import java.time.Instant

@BelongsToContract(NodeInfoContract::class)
data class NodeInfoShareState(
        val origin: Party,
        val target: Party,
        var nodeInfoContainer: NodeInfoContainer,
        override val linearId: UniqueIdentifier = UniqueIdentifier()) : LinearState {
    override val participants: List<Party> get() = listOf(origin, target)
}



