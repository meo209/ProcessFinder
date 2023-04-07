package com.github.meo209;

import com.sun.tools.attach.VirtualMachine;
import com.sun.tools.attach.VirtualMachineDescriptor;

import java.util.List;
import java.util.Objects;

public class ProcessFinder {

    public static String searchForProcess(String displayName) {
        List<VirtualMachineDescriptor> vms = VirtualMachine.list();
        for (VirtualMachineDescriptor vm : vms) {
            if (vm.displayName().contains(displayName)) return vm.id();
        }
        return "VM Not found!";
    }

    public static String searchForMinecraftVM() {
        return searchForProcess("Minecraft");
    }

    public static VirtualMachineDescriptor getVMDescriptor(String id) {
        List<VirtualMachineDescriptor> vms = VirtualMachine.list();
        for (VirtualMachineDescriptor vm : vms) {
            if (Objects.equals(vm.id(), id)) return vm;
        }
        return null;
    }

}