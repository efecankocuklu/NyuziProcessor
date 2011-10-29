package emulatordebug;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IRegisterGroup;
import org.eclipse.debug.core.model.IStackFrame;
import org.eclipse.debug.core.model.IThread;
import org.eclipse.debug.core.model.IVariable;

public class TargetStackFrame extends EmulatorDebugElement implements
		IStackFrame
{
	public TargetStackFrame(EmulatorDebugTarget target, TargetThread thread, TargetRegisterGroup[] registerGroups)
	{
		super(target);
		fThread = thread;
		fRegisterGroups = registerGroups;
	}

	public boolean canStepInto()
	{
		return getThread().canStepInto();
	}

	public boolean canStepOver()
	{
		return getThread().canStepOver();
	}

	public boolean canStepReturn()
	{
		return getThread().canStepReturn();
	}

	public boolean isStepping()
	{
		return getThread().isStepping();
	}

	public void stepInto() throws DebugException
	{
		getThread().stepInto();
	}

	public void stepOver() throws DebugException
	{
		getThread().stepOver();
	}

	public void stepReturn() throws DebugException
	{
		getThread().stepReturn();
	}

	public boolean canResume()
	{
		return getThread().canResume();
	}

	public boolean canSuspend()
	{
		return getThread().canSuspend();
	}

	public boolean isSuspended()
	{
		return getThread().isSuspended();
	}

	public void resume() throws DebugException
	{
		getThread().resume();
	}

	public void suspend() throws DebugException
	{
		getThread().suspend();
	}

	public boolean canTerminate()
	{
		return getThread().canTerminate();
	}

	public boolean isTerminated()
	{
		return getThread().isTerminated();
	}

	public void terminate() throws DebugException
	{
		getThread().terminate();
	}

	public int getCharEnd() throws DebugException
	{
		return -1;
	}

	public int getCharStart() throws DebugException
	{
		return -1;
	}

	public int getLineNumber() throws DebugException
	{
		return getEmulatorDebugTarget().getLineNumber();
	}
	
	public String getSourceName()
	{
		return getEmulatorDebugTarget().getSourceName();
	}
	
	public String getName() throws DebugException
	{
		return "top of stack";
	}

	public IRegisterGroup[] getRegisterGroups() throws DebugException
	{
		return fRegisterGroups;
	}

	public IThread getThread()
	{
		return fThread;
	}

	public IVariable[] getVariables() throws DebugException
	{
		return null;
	}

	public boolean hasRegisterGroups() throws DebugException
	{
		return true;
	}

	public boolean hasVariables() throws DebugException
	{
		return false;
	}
	
	private TargetRegisterGroup[] fRegisterGroups;
	private TargetThread fThread;
}
